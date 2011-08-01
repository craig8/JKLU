/**
 * KLU: a sparse LU factorization algorithm.
 * Copyright (C) 2004-2009, Timothy A. Davis.
 * Copyright (C) 2011, Richard W. Lincoln.
 * http://www.cise.ufl.edu/research/sparse/klu
 *
 * -------------------------------------------------------------------------
 *
 * KLU is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * KLU is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this Module; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */

package edu.ufl.cise.klu.tdouble;

import edu.ufl.cise.klu.common.KLU_common;
import edu.ufl.cise.klu.common.KLU_symbolic;

/**
 * Free the KLU Symbolic object.
 */
public class Dklu_free_symbolic extends Dklu_internal
{

	public static int klu_free_symbolic(KLU_symbolic SymbolicHandle,
			KLU_common Common)
	{
	    KLU_symbolic Symbolic ;
	    int n ;
	    if (Common == null)
	    {
	        return (FALSE) ;
	    }
	    if (SymbolicHandle == null)
	    {
	        return (TRUE) ;
	    }
	    Symbolic = SymbolicHandle ;
	    n = Symbolic.n ;
	    KLU_free (Symbolic.P, n, sizeof (Integer), Common) ;
	    KLU_free (Symbolic.Q, n, sizeof (Integer), Common) ;
	    KLU_free (Symbolic.R, n+1, sizeof (Integer), Common) ;
	    KLU_free (Symbolic.Lnz, n, sizeof (Souble), Common) ;
	    KLU_free (Symbolic, 1, sizeof (KLU_symbolic), Common) ;
	    SymbolicHandle = null ;
	    return (TRUE) ;
	}

}