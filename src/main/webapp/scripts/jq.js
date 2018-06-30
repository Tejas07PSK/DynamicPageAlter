/*
        @Author : Palash Sarkar
        @CreatedON : 30 JUNE, 2018, 1:46:53 PM
        @FILEName :  jq.js
 */

$(document).ready(function(){

        $("span#tab_inp_frm").children("button").click(function(){

            tab_nm = ($("span#tab_inp_frm").children("input").val()).trim();
            tab_det = ($("span#tab_inp_frm").children("textarea").val()).trim();

            console.log(tab_nm);
            console.log(tab_det);
            
        });

});