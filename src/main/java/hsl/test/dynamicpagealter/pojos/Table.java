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
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Table implements Serializable
{

        private static final long serialVersionUID = 1L;

        private final String tab_name;
        private final HashMap<String, String> row_nm_typ = new HashMap <> ();

        private Table(String tb)
        {

            tab_name = tb;

        }

        public Table(String tb, String [] col_nms_typs)
        {

            this(tb);
            fillHashMap(col_nms_typs);

        }

        private void fillHashMap(String [] col_nms_typs)
        {

                for(String var : col_nms_typs)
                {
                        row_nm_typ.put((var.split("-"))[0], (var.split("-"))[1]);
                }

        }

        public Set getEntries()
        {

                return (row_nm_typ.entrySet());

        }

        public Set getKeys()
        {

                return (row_nm_typ.keySet());

        }

        public Collection getValues()
        {

                return (row_nm_typ.values());

        }

        public int getHmpSize()
        {

                return (row_nm_typ.size());

        }

}
