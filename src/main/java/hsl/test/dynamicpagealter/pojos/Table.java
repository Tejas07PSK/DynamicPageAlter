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
        private static Table sing_obj = null;

        private String tab_name;
        private final HashMap<String, String> row_nm_typ;

        private Table()
        {

            tab_name = "";
            row_nm_typ = new HashMap <> ();

        }

        private void fillHashMap(String [] col_nms_typs)
        {

                for(String var : col_nms_typs)
                {

                        row_nm_typ.put((var.split("-"))[0], (var.split("-"))[1]);

                }

        }

        public Table getSing_obj()
        {

                if (sing_obj == null)
                        sing_obj = new Table();
                return (sing_obj);

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

        public void emptyHshmp()
        {

                row_nm_typ.clear();
                System.out.println("Hash-Map Cleaned Successfully!!");

        }

        private boolean checkIfKeyExists(String key)
        {

                return (row_nm_typ.containsKey(key));

        }

        public boolean checkIfValueExists(String val)
        {

                return (row_nm_typ.containsValue(val));

        }

        public String getValueForKey(String key)
        {

                if (checkIfKeyExists(key))
                        return (row_nm_typ.get(key));
                else
                        System.out.println("Key : " + key + "doesnot exist!!");
                        return (null);

        }

        public boolean checkIfHsmpIsEmpty()
        {

                return (row_nm_typ.isEmpty());

        }

        public void insertIntoHsmp(String key, String val)
        {

                System.out.println("Previous mapped value for Key - " + key + " : " + row_nm_typ.put(key, val));
                System.out.println("Key-Value pair successfully inserted!!");

        }

        public void deleteEntryInHsmp(String key, String val)
        {

                if (row_nm_typ.remove(key, val))
                        System.out.println("Entry successfully removed from Hash-Map!!");
                else
                        System.out.println("Entry not found, couldnot remove Key-Value pair!!");

        }

        public void modifyEntryInHsmp(String key, String val)
        {

                if (checkIfKeyExists(key))
                        row_nm_typ.replace(key, val);
                else
                        System.out.println("Key does not exist in Hash-Map!!");

        }

}
