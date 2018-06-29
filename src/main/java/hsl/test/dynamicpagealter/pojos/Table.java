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

        synchronized public void fillHashMap(String [] col_nms_typs)
        {

                for(String var : col_nms_typs)
                {

                        insertIntoHsmp((var.split("-"))[0], (var.split("-"))[1]);

                }

        }

        synchronized public static Table getSing_obj()
        {

                if (sing_obj == null)
                        sing_obj = new Table();
                return (sing_obj);

        }

        synchronized public void setTableName(String tab_name)
        {

                this.tab_name = tab_name;

        }

        synchronized public String getTableName()
        {

                return (tab_name);

        }

        synchronized public Set getEntries()
        {

                return (row_nm_typ.entrySet());

        }

        synchronized public Set getKeys()
        {

                return (row_nm_typ.keySet());

        }

        synchronized public Collection getValues()
        {

                return (row_nm_typ.values());

        }

        synchronized public int getHmpSize()
        {

                return (row_nm_typ.size());

        }

        synchronized public void emptyHshmp()
        {

                row_nm_typ.clear();
                System.out.println("Hash-Map Cleaned Successfully!!");

        }

        synchronized private boolean checkIfKeyExists(String key)
        {

                return (row_nm_typ.containsKey(key));

        }

        synchronized public boolean checkIfValueExists(String val)
        {

                return (row_nm_typ.containsValue(val));

        }

        synchronized public String getValueForKey(String key)
        {

                if (checkIfKeyExists(key))
                        return (row_nm_typ.get(key));
                else
                        System.out.println("Key : " + key + "doesnot exist!!");
                        return (null);

        }

        synchronized public boolean checkIfHsmpIsEmpty()
        {

                return (row_nm_typ.isEmpty());

        }

        synchronized private void insertIntoHsmp(String key, String val)
        {

                System.out.println("Previous mapped value for Key - " + key + " : " + row_nm_typ.put(key, val));
                System.out.println("Key-Value pair successfully inserted!!");

        }

        synchronized public void deleteEntryInHsmp(String key, String val)
        {

                if (row_nm_typ.remove(key, val))
                        System.out.println("Entry successfully removed from Hash-Map!!");
                else
                        System.out.println("Entry not found, couldnot remove Key-Value pair!!");

        }

        synchronized public void modifyEntryInHsmp(String key, String val)
        {

                if (checkIfKeyExists(key))
                        row_nm_typ.replace(key, val);
                else
                        System.out.println("Key does not exist in Hash-Map!!");

        }

}
