package com.paracamplus.ilp1.ilp1tme1;
import java.io.File;
import java.io.IOException;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.test.*;
import com.paracamplus.ilp1.parser.ParseException;

public class FileInterpreter extends InterpreterTest{



	public FileInterpreter(File file) {
		super(file);
	}

	public static void main (String[] args)  {
	
			InterpreterTest it = new InterpreterTest(new File(args[0]));
			try {
				it.processFile();
			} catch (ParseException | IOException | EvaluationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
	}
}
