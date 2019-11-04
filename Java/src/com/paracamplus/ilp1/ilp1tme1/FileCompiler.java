package com.paracamplus.ilp1.ilp1tme1;
import java.io.File;
import java.io.IOException;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.test.*;
import com.paracamplus.ilp1.parser.ParseException;

public class FileCompiler extends CompilerTest{

	public FileCompiler(File file) {
		super(file);
	}
	
	public static void main (String[] args) {
		for (String s : args) {
			CompilerTest f = new CompilerTest(new File(s));
			try {
				f.processFile();
			} catch (CompilationException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
