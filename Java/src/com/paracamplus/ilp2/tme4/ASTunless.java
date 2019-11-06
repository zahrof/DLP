package com.paracamplus.ilp2.tme4;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitable;
import com.paracamplus.ilp2.tme4.IASTvisitor;

public class ASTunless extends ASTexpression implements IASTunless,IASTvisitable {

	public ASTunless(IASTexpression bdy,
			IASTexpression cond) {
		this.bdy = bdy;
		this.cond = cond;
	}

	private final IASTexpression bdy;
	private final IASTexpression cond;

	@Override
	public IASTexpression getBdy() {
		return bdy; 
	}

	@Override
	public IASTexpression getCond() {
		return cond; 
	}

	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(
			com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		return ((IASTvisitor <Result, Data, Anomaly>) visitor).visit(this, data);
	}


}
