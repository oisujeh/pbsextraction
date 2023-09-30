<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<div class="row wrapper  white-bg page-heading"  style="">
    <h4 style="text-align: center">
        Extract PBS for APIN Internal Deduplication
    </h4>
</div>


<div class="container" style="padding-top: 10px;">
    <div style="margin-left: 32%; width: 40%; height: 50%; background-color: #00463f; border-radius: 10px; ">
        <br/> <br/>
        <div>
            <label id="lblfrom" for="startdate" style="color: white; margin-left: 50px;">Start Date</label><br id="br4">
            <input style="background-color: #E8F0FE; margin-left: 52px;margin-bottom: 15px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px;" name="startdate" id="startdate" type="date"/><br>
            <label id="lblto" for="enddate" style="color: white; margin-left: 50px;">End Date</label><br id="br6">
            <input style="background-color: #E8F0FE; margin-left: 52px;margin-bottom: 15px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px;" name="enddate" id="enddate" type="date"/><br>
            <input style="background-color: #E8F0FE; margin-left: 52px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px" type="button" value="Export" onclick="getStart()" class="btn btn-primary" />
        </div>
        <br/><br/>
    </div>
    <br/>
    <div class="table-responsive">
        <table class="table table-striped table-bordered  table-hover" id="tb_commtester">
            <thead>
            <tr>
                <th>${ ui.message("File Name") }</th>
                <th>${ ui.message("Date Started") }</th>
                <th>${ ui.message("Date Completed") }</th>
                <th>${ ui.message("Total No. of Patients") }</th>
                <th>${ ui.message("Actions") }</th>
            </tr>

            </thead>
            <tbody id="TableBody">

            </tbody>
        </table>
    </div>
    <div id="gen-wait" class="dialog" style="display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); z-index: 9999;">
        <div class="row">
            <div class="col-md-3 col-xs-3 offset-2" >
                <img src="../moduleResources/pbsextraction/images/Sa7X.gif" alt="Loading Gif"  style="width:100px">
            </div>
        </div>

        <div>
            <div class="col-md-7 col-xs-7 " style="text-align:center;">
                <h1>Please wait, operation in progress...</h1>
            </div>
        </div>
    </div>
</div>

<script>

    var jq = jQuery;

    function getStart() {
        // Show 'gen-wait' element when processing starts.
        jq('#gen-wait').show();

        console.log("Started Job");
        var startdate = document.getElementById("startdate").value;
        var enddate = document.getElementById("enddate").value;

        jq.ajax({
            url: "${ ui.actionLink("pbsextraction", "pbsextractionHome", "extractFingerprint") }",
            dataType: "json",
            data:{
                'startdate':startdate,
                'enddate':enddate,
            },
            success: function (response) {
                // Hide 'gen-wait' element when a response is received.
                jq('#gen-wait').hide();
                console.log(response);
                var res = JSON.parse(response);
                console.log(res);

                if(isObjectEmpty(res)){
                    console.log("Response is empty");
                }else {
                    console.log("Response is not empty");
                }

                jq('#TableBody')
                    .append("<tr>" +
                        "<td>" + res[0] + "</td>" +
                        "<td>" + res[1] + "</td>" +
                        "<td>" + res[1] + "</td>" +
                        "<td>" + res[2] + "</td>" +
                        "<td><a href='" + res[3] + "' download>Download</a></td>" +
                        "</tr>");
            },
            error:function(xhr){
                // Hide 'gen-wait' element if an error occurs.
                jq('#gen-wait').hide();
                console.log(xhr);
            }
        });
    }

    function isObjectEmpty (objectName) {
        for (var prop in objectName) {
            if (objectName.hasOwnProperty(prop)) {
                return false;
            }
        }
        return true;
    }
</script>


<script>
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();

    today = yyyy + '-' + mm + '-' + dd;
    document.getElementById("startdate").setAttribute("max", today);
    document.getElementById("enddate").setAttribute("max", today);
</script>
