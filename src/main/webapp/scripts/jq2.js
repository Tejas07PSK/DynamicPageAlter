/*
        @Author : Palash Sarkar
        @CreatedON : 1 JUL, 2018, 1:56:23 AM
        @FILEName :  jq2.js
 */

$(document).ready(function(){

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
                        console.log()
                        var str_arr = respdata.split("-");
                },
                success : function (result,status,xhr)
                {
                    $("span#output").html($("span#output").html()+"<br/>"+"SUCCESS;"+"<br/>"+"statusText : "+status+"<br/>"+"statusCode : "+xhr.status+"<br/>"+"readyState : "+xhr.readyState+"<br/>"+"response : "+JSON.stringify(result)+"<br/>");
                    if (result.USER_SAVED_ADDRS === undefined)
                    {
                        console.log("Error handled!!");
                    }
                    else
                    {
                        if ((result.USER_SAVED_ADDRS).length === 0)
                        {
                            $("span#lst_lod")["0"].style.display = "block";
                            $("span#lst_lod").children("span#lst_txt")["0"].style.display = "block";
                        }
                        else
                        {
                            for (i=0;i<(result.USER_SAVED_ADDRS).length;i++)
                            {
                                appndTrs(result.USER_SAVED_ADDRS[i].ADD_ID,result.USER_SAVED_ADDRS[i].SVD_LOCALITY,result.USER_SAVED_ADDRS[i].SVD_CITY,result.USER_SAVED_ADDRS[i].SVD_ZIPCODE,result.USER_SAVED_ADDRS[i].STATE,result.USER_SAVED_ADDRS[i].SVD_COUNTRY);
                            }
                        }
                    }
                },
                error : function (xhr,status,error)
                {
                    $("span#message").html("Login Failed").css("color","red");
                    $("div#result_img").css({"background-image":"url('images/failed.png')", "-webkit-animation":"vibrate 0.2s linear 0s 15 alternate", "animation":"vibrate 0.2s linear 0s 15 alternate", "background-position":"center", "background-color":"rgba(0,0,0,0.6)"});
                    $("span#output").html($("span#output").html()+"<br/>"+"ERROR;"+"<br/>"+"statusText : "+status+"<br/>"+"statusCode : "+xhr.statusText+"<br/>"+"readyState : "+xhr.readyState+"<br/>"+"errorText : "+error+"<br/>");
                },
                complete : function (xhr,status)
                {
                    $("div#mod_loader").css("display","none");
                    $("span#message").delay(100).css("display","block");
                    $("span#output").html($("span#output").html()+"<br/>"+"FINISHED;"+"<br/>"+"readyState : "+xhr.readyState+"<br/>"+"statusCode : "+xhr.status+"<br/>"+"statusText : "+status+"<br/><br/><br/>").parent().css("display","block");
                    $("button#cnt_shpp").delay(100).css("display","block");
                    $("div#result_img").delay(200).css("display","block");
                    $("div#space").delay(200).css("display","block");
                    $("div#lod").animate({ scrollTop: 0 }, "slow");
                },
                headers : {
                    'Accept': 'json',
                    'Content-Type': 'application/x-www-form-urlencoded',
                    "X-HTTP-Method-Override": "POST"
                }
            });

        }

});