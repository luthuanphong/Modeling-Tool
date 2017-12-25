package editor.utils;

import javax.xml.bind.JAXBException;

import Petrinet.Arc;
import Petrinet.Petrinet;
import Petrinet.Place;
import Petrinet.Pnml;
import Petrinet.Transition;
import Petrinet.xml.PnmlImporter;
import java.lang.RuntimeException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.tree.*;
import ast.parser.*;
import ast.ptnet.PTNETLexer;
import ast.ptnet.PTNETParser;
import ast.gen.*;
import ast.struct.*;
import java.io.*;
import java.util.Enumeration;
import Petrinet.*;
import java.util.HashMap;
import java.util.Map;

public class Verify {

	private static Program prog = null;

	private static void writeStringToFile(String content) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String FILENAME="out.txt";

		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
				bw.close();
				if (fw != null)
				fw.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void println(HashMap<String, Integer> h) {
		for (Map.Entry<String, Integer> t: h.entrySet()) {
			System.out.println(t);
		}
	}

	private static Graph genGraph(String file, Petrinet pt) throws Exception {
		//Program prog = null;
		ANTLRFileStream source = new ANTLRFileStream(file); // in bin folder
		//try {
		PTNETLexer lexer = new PTNETLexer(source);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PTNETParser parser = new PTNETParser(tokens);
		prog = (Program)new ASTGen().visit(parser.program()); // program object
		//prog.accept(new StaticCheck(), prog.varList);
		//} catch (RuntimeException e) {
		//	System.out.println("There is an error: " + e);
		//}
		/*
		* To do: write code to test if we verified correctly
		*/
		Graph g = pt.WSNGenerate(prog);
		return g;
	}

		public static String getVeriInfo(String pnmlFile, String txtFile, String min_txtFile) throws Exception {
		/*
		* Read pnml file
		*/
		Pnml pnml = new PnmlImporter().readFromFile(pnmlFile); // in bin folder
		Petrinet pt = pnml.getPetrinet();  // Petri net object

		/*
		* Read code for compiler
		*/
		Graph g = genGraph(txtFile, pt);
		//writeStringToFile(s);
    StringBuilder sb = new StringBuilder();
    sb.append("The reachability graph has ").append(g.getSize()).append(" nodes");
		if (g.getSize()>300000) {
			sb.append(" (partial).\n");
		} else {
			sb.append(" (full).\n");
		}
		SearchStmt stmt = (SearchStmt)prog.funcList.get("main").block.stmts.get(0);
		String congest = g.search(stmt, prog.constList);
    if (congest.isEmpty()) {
      sb.append("No congestion is found");
      return sb.toString();
    } else {
      Vertex congestState = g.searchState(stmt, prog.constList);
      sb.append(congest).append("Congest state is ").append(congestState.toString()).append("\n");
			//sb.append(congest);
			// Vertex cv = g.searchState(stmt, prog.constList);
			// HashMap<String, Integer> ht = g.generateHeuristicTable(cv);
			// g.heuristicSearch(cv, ht, prog.constList);
      // return sb.toString();
			// String Hcongest = g.newSearch(stmt, prog.constList);
			// if (Hcongest.isEmpty()) {
			// 	sb.append("No congestion is found");
			// 	return sb.toString();
			// } else {
			// 	sb.append(Hcongest);
			// 	return sb.toString();
			// }
			return sb.toString();
    }
		// Graph gs = genGraph("temp_minimize.txt", pt);
		// gs.println();
		// HashMap<String, Integer> h = gs.generateHeuristicTable(congestState);
		// println(h);
		// System.out.println("\n" + g.search(stmt) + "\n");
	}
}
