package com.paracamplus.ilp2.tme4;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASToperator;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.tme4.IASTvisitor;

public class TransformUnlesstoIf implements IASTvisitor<IASTexpression, Void, EvaluationException> {

	public TransformUnlesstoIf (com.paracamplus.ilp2.interfaces.IASTfactory factory) {
		this.factory = factory;
	}


	protected final com.paracamplus.ilp2.interfaces.IASTfactory factory;

	public IASTexpression visit(IASTprogram iast, Void data) throws EvaluationException {
		return iast.getBody().accept(this, null);
	}

	@Override
	public IASTexpression visit(IASTassignment iast, Void data) throws EvaluationException {
		IASTexpression expr = iast.getExpression().accept(this, null); 
		return factory.newAssignment(iast.getVariable(), expr); 
	}

	@Override
	public IASTexpression visit(IASTloop iast, Void data) throws EvaluationException {
		IASTexpression condition = iast.getCondition().accept(this, null); 
		IASTexpression body = iast.getBody().accept(this, null); 
		return factory.newLoop(condition, body); 
	}

	@Override
	public IASTexpression visit(IASTalternative iast, Void data) throws EvaluationException {
		IASTexpression c = iast.getCondition().accept(this, null);
		IASTexpression t = iast.getConsequence().accept(this, null);
		if ( iast.isTernary() ) {
			IASTexpression a = iast.getAlternant().accept(this, null);
			return factory.newAlternative(c, t, a);
		} else {
			IASTexpression whatever = factory.newBooleanConstant("false");
			return factory.newAlternative(c, t, whatever);
		}
	}

	@Override
	public IASTexpression visit(IASTbinaryOperation iast, Void data) throws EvaluationException {
		IASTexpression leftOperand = iast.getLeftOperand().accept(this, null); 
		IASTexpression rightOperand = iast.getRightOperand().accept(this, null); 
		return factory.newBinaryOperation(iast.getOperator(), leftOperand, rightOperand);
	}

	@Override
	public IASTexpression visit(IASTblock iast, Void data) throws EvaluationException {
		IASTblock.IASTbinding[] bindings = iast.getBindings();
		IASTblock.IASTbinding[] newbindings = new IASTblock.IASTbinding[bindings.length];
		int i=0;
		for(IASTblock.IASTbinding b : iast.getBindings()){
			IASTexpression nexp= b.getInitialisation().accept(this,null);
			IASTvariable nevar= b.getVariable();
			newbindings[i++]=factory.newBinding(nevar,nexp);
		}
		IASTexpression newbody = iast.getBody().accept(this, null);
		return factory.newBlock(newbindings, newbody);
	}

	@Override
	public IASTexpression visit(IASTboolean iast, Void data) throws EvaluationException {
		return iast; 
	}

	@Override
	public IASTexpression visit(IASTfloat iast, Void data) throws EvaluationException {
		return iast; 
	}

	@Override
	public IASTexpression visit(IASTinteger iast, Void data) throws EvaluationException {
		return iast; 
	}

	@Override
	public IASTexpression visit(IASTinvocation iast, Void data) throws EvaluationException {
		  return iast;
	}

	@Override
	public IASTexpression visit(IASTsequence iast, Void data) throws EvaluationException {
		IASTexpression[] expressions = iast.getExpressions();
        IASTexpression[] exprs = new IASTexpression[expressions.length];
        for ( int i=0 ; i< expressions.length ; i++ ) {
            exprs[i] = expressions[i].accept(this, null);
        }
        if ( iast.getExpressions().length == 1 ) {
            return exprs[0];
        } else {
            return factory.newSequence(exprs);
        }
	}

	@Override
	public IASTexpression visit(IASTstring iast, Void data) throws EvaluationException {
		return iast; 
	}

	@Override
	public IASTexpression visit(IASTunaryOperation iast, Void data) throws EvaluationException {
		IASToperator operator = iast.getOperator();
		IASTexpression operand = iast.getOperand().accept(this, null);
		return factory.newUnaryOperation(operator, operand);
	}

	@Override
	public IASTexpression visit(IASTvariable iast, Void data) throws EvaluationException {
		return iast; 
	}

	@Override
	public IASTexpression visit(IASTunless iast, Void data) throws EvaluationException {
	    IASTexpression newcond=iast.getCond().accept(this,null);
        IASTexpression newbody=iast.getBdy().accept(this,null);
        return factory.newAlternative(newcond,null,newbody);
	}



}
