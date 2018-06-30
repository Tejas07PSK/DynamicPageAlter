/*
        @Author : Palash Sarkar
        @CreatedON : 30 JUNE, 2018, 1:46:53 PM
        @FILEName :  jq.js
 */

$(document).ready(function(){

        $("span#tab_inp_frm").children("button").click(function(){

                tab_nm = ($("span#tab_inp_frm").children("input").val()).trim();
                tab_det = ($("span#tab_inp_frm").children("textarea").val()).trim();

                $.post("relServlet",
                        {

                                "tab_nme" : tab_nm,
                                "tab_type_inf" : tab_det

                        },
                        function(data,status,xhr)
                        {
                                if (xhr.readyState === 4 & xhr.status === 200)
                                {

                                        alert("Details :<br/>" + xhr.readyState + "<br/>" + status + "<br/>" + xhr.status + "<br/>" + String(data) + "<br/>" + xhr.responseText);

                                }
                                else
                                {

                                        alert("Details :<br/>" + xhr.readyState + "<br/>" + status + "<br/>" + xhr.status + "<br/>" + xhr.responseText);

                                }
                        }, "text");

        });

});