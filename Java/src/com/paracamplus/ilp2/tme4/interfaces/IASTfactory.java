/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.tme4.interfaces;


import com.paracamplus.ilp1.interfaces.IASTexpression;



public interface IASTfactory extends com.paracamplus.ilp2.interfaces.IASTfactory  {
   
	IASTexpression newUnlesss(IASTexpression bdy, IASTexpression cond);
    
}
