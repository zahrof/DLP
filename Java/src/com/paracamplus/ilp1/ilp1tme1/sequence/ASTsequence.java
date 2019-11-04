package com.paracamplus.ilp1.ilp1tme1.sequence;

import java.util.Arrays;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ASTsequence extends com.paracamplus.ilp1.ast.ASTsequence implements com.paracamplus.ilp1.ilp1tme1.sequence.IASTsequence {

	public ASTsequence(IASTexpression[] expressions) {
		super(expressions);
	}

	@Override
	public IASTexpression[] getExpressions() {
		return super.getExpressions(); 
	}

	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		System.out.println("dogs");
		 return visitor.visit(this, data);
	}

	@Override
	public IASTexpression[] getAllButLastInstructions() throws EvaluationException {
		IASTexpression[] or= this.getExpressions(); 
	
		Arrays.copyOf(or, or.length-1);

		return or; 
	}


}
