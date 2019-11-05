package com.paracamplus.ilp1.ilp1tme2.ex2;



import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class CountConstants implements
com.paracamplus.ilp1.interfaces.IASTvisitor<Integer, Void , EvaluationException> {

	int count; 
	
	public CountConstants() {
		this.count=0; 
	}
	
	public int getCount() {
		return count;
	}
	
	public Integer visit(IASTprogram iast,Void data) 
            throws EvaluationException {
        
            return iast.getBody().accept(this, null);
        
    }
   
	@Override
	public Integer visit(IASTalternative iast, Void data) throws EvaluationException {
		  int c = iast.getCondition().accept(this, null);
		  int conseq = iast.getConsequence().accept(this, null) ;
		  if ( iast.isTernary() ) {
			  int alt = iast.getAlternant().accept(this, null);
			  return  c+conseq+alt;
		  }else return c+conseq;
		  
		  
	}

	@Override
	public Integer visit(IASTbinaryOperation iast, Void data) throws EvaluationException {
		Integer leftOperand = iast.getLeftOperand().accept(this, null);
        Integer rightOperand = iast.getRightOperand().accept(this, null);
        return leftOperand + rightOperand; 
	}

	@Override
	public Integer visit(IASTblock iast, Void data) throws EvaluationException {
		int initialisation=0;
		for (IASTbinding binding : iast.getBindings()) {
			initialisation +=binding.getInitialisation().accept(this, null);
		}
		return initialisation; 
	}

	@Override
	public Integer visit(IASTboolean iast, Void data) throws EvaluationException {
		return 1;  
	}

	@Override
	public Integer visit(IASTfloat iast, Void data) throws EvaluationException {
		return 1;
	}

	@Override
	public Integer visit(IASTinteger iast, Void data) throws EvaluationException {
		return 1;
	}

	@Override
	public Integer visit(IASTinvocation iast, Void data) throws EvaluationException {
		int function =  iast.getFunction().accept(this, null);
		for ( IASTexpression arg : iast.getArguments() ) {
             function += arg.accept(this, null);
        }
		return function; 
	}

	@Override
	public Integer visit(IASTsequence iast, Void data) throws EvaluationException {
		 IASTexpression[] expressions = iast.getExpressions();
	        int lastValue = 0;
	        for ( IASTexpression e : expressions ) {
	            lastValue += e.accept(this, null);
	        }
	        return lastValue;
	}

	@Override
	public Integer visit(IASTstring iast, Void data) throws EvaluationException {
		return 1;
	}

	@Override
	public Integer visit(IASTunaryOperation iast, Void data) throws EvaluationException {
		return iast.getOperand().accept(this, null); 
	}

	@Override
	public Integer visit(IASTvariable iast, Void data) throws EvaluationException {
		return 0;
	}

 

}
