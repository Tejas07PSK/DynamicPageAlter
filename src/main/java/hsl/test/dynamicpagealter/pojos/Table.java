/*  -> Designed for testing and development purposes.
 *  -> Project to design a DynamicPageAlter webapp prototype.
 *  -> Development Phase  -- Premature.
 *  -> Project Type  -- Educational.
 *  -> Organization -- HSL.
 *  -> Owner/Code file Designer :
 *             @ Name - Palash Sarkar.
 *             @ Email - palashsarkar0007@gmail.com.
 *  -> Copyright Norms - Every piece of code given below
 *                       has been written by 'Palash Sarkar (Tj07)'©,
 *                       and he holds the rights to the file. Not meant to be
 *                       copied or tampered without prior permission from the author.
 *  -> Guide -
 */

package hsl.test.dynamicpagealter.pojos;

import java.io.Serializable;
import java.util.HashMap;

public class Table implements Serializable
{

        private static final long serialVersionUID = 1L;

        private final String tab_name;
        private final HashMap var_nm_typ = new HashMap <String, String> ();

        private Table(){}

        private Table(String tb)
        {

            tab_name = tb;

        }

        public Table(String tb, String [] col_nms, String [] col_types)
        {

            this( tb );
            

        }

}
