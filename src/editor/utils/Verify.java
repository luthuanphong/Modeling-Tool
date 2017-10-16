package editor.utils;

import Petrinet.Petrinet;
import Petrinet.Pnml;
import Petrinet.xml.PnmlImporter;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import ast.ptnet.PTNETLexer;
import ast.ptnet.PTNETParser;
import ast.gen.*;
import ast.struct.*;
import java.io.*;
import Petrinet.*;
import java.util.HashMap;
import java.util.Map;

public class Verify {

	private Program prog = null;

	private  void writeStringToFile(String content) {
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

	private  void println(HashMap<String, Integer> h) {
		for (Map.Entry<String, Integer> t: h.entrySet()) {
			System.out.println(t);
		}
	}

	private  Graph genGraph(String file, Petrinet pt) throws Exception {
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

	public String getVeriInfo(String pnmlFile, String txtFile, String min_txtFile) throws Exception {
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
    sb.append("The reachability graph has ").append(g.getSize()).append(" nodes.\n");
		SearchStmt stmt = (SearchStmt)prog.funcList.get("main").block.stmts.get(0);
		String congest = g.search(stmt, prog.constList);
    if (congest.isEmpty()) {
      sb.append("No congestion is found");
      return sb.toString();
    } else {
      Vertex congestState = g.searchState(stmt, prog.constList);
      sb.append(congest).append("Congest state is ").append(congestState.toString());
      return sb.toString();
    }
		// Graph gs = genGraph("temp_minimize.txt", pt);
		// gs.println();
		// HashMap<String, Integer> h = gs.generateHeuristicTable(congestState);
		// println(h);
		// System.out.println("\n" + g.search(stmt) + "\n");
	}
}
