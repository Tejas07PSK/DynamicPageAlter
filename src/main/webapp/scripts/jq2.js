/*
        @Author : Palash Sarkar
        @CreatedON : 1 JUL, 2018, 1:56:23 AM
        @FILEName :  jq2.js
 */

$(document).ready(function(){

        chk_chg(0);

        function chk_chg (cnt)
        {

            $.ajax({

                        url : "relServlet" ,
                        async : true,
                        cache : true,
                        contentType : "text",
                        processData : true,
                        scriptCharset : "UTF-8",
                        type : 'GET',
                        traditional : true,
                        timeout : 0,
                        dataType : "text",
                        data : {

                                    "iter" : cnt,
                                    "sch_nme" : "DynamicPageAlter"

                               },
                        beforeSend : function (xhr)
                                     {

                                            xhr.overrideMimeType('text');

                                     },
                        dataFilter : function (respdata, type)
                                     {

                                            console.log(String(type))
                                            var str_arr = respdata.split("-");
                                            var new_str = "";
                                            for(i=0; i < str_arr.length; i++)
                                            {
                                                    new_str += str_arr[i] + "<br/>";
                                            }
                                            return (new_str)

                                     },
                        success : function (result,status,xhr)
                                  {

                                        console.log(result);
                                        console.log(xhr.readyState);
                                        console.log(xhr.status);
                                        console.log(status);
                                        console.log(xhr.responseText);
                                        $("div#result").html(String(result));

                                  },
                        error : function (xhr,status,error)
                                {

                                        console.log("Details : \n" + xhr.readyState + "\n" + xhr.status + "\n" + status + "\n" + xhr.responseText + "\n" + error);

                                },
                        complete : function (xhr,status)
                                   {

                                       console.log("Details : \n" + xhr.readyState + "\n" + xhr.status + "\n" + status + "\n" + xhr.responseText);
                                       cnt += 1;
                                       chk_chg(cnt);

                                   },
                        headers : {

                                        "Accept": "text",
                                        "Content-Type": "text",
                                        "X-HTTP-Method-Override": "POST"

                                  }

                });

        }

});