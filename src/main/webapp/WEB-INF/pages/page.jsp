<html>
<head>
    <title>Web Application</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!--append css and jquery from google-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>

<body>

<!--script for selector 'Time period'-->
<script>
    function timePeriod() {
        var select = document.getElementById("select").options.selectedIndex;

        if (select == 2) {

            var input1 = document.getElementById('startDateId');
            input1.value = "${LastQtrStartDate}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${LastQtrEndDate}"
        }
        else if (select == 3) {

            var input1 = document.getElementById('startDateId');
            input1.value = "${LastMonthStartDate}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${LastMonthEndDate}"
        }
        else if (select == 4) {

            var input1 = document.getElementById('startDateId');
            input1.value = "${LastYearStartDate}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${LastYearEndDate}"
        }
        else if (select == 5) {
            var input1 = document.getElementById('startDateId');
            input1.value = "${currentYearToDate}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${endDateCurrentQuery}"
        }
        else if (select == 6) {
            var input1 = document.getElementById('startDateId');
            input1.value = "${currentQerToDate}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${endDateCurrentQuery}"
        }
        else if (select == 7) {
            var input1 = document.getElementById('startDateId');
            input1.value = "${currentMonthToDate}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${endDateCurrentQuery}"
        }
    }
</script>

<div class="parent">
    <div class="block">
        <div class="containerForm">
            <!--Title-->
            <div class="title">
                Web application
            </div>
            <div class="formInput">
                <!--Input search by start and end date form-->
                <form action="/report" method="post" id="formForReport">
                    <p>
                        Start date: <input type="text" class="inputDateField1" name="startDate" id="startDateId">

                    <p>
                        End date: <input type="text" class="inputDateField2" name="endDate" id="endDateId">

                    <p>
                        <!--Selector 'Performers'-->
                        Performer: <select id="allPerformers" class="selectPerfAll" name="performer"
                                           form="formForReport">

                        <option disabled>chose performance</option>
                        <option selected value="empty"></option>
                        <option value="All Performers">All Performers</option>
                    </select>

                    <p>
                        <!--Selector 'Time period'-->
                        Time period: <select id="select" class="selectTimePeriod" name="time date" form="formForReport"
                                             onchange="timePeriod()">
                        <option disabled>chose time period</option>
                        <option selected value="empty"></option>
                        <option id="Last Qtr" value="Last Qtr">Last Qtr</option>
                        <option id="Last Month" value="Last Month">Last Month</option>
                        <option id="Last Calendar Year" value="Last Calendar Year">Last Calendar Year</option>
                        <option id="Current Year to Date" value="Current Year to Date">Current Year to Date</option>
                        <option id="Current Qtr to Date" value="Current Qtr to Date">Current Qtr to Date</option>
                        <option id="Current Month to Date" value="Current Month to Date">Current Month to Date</option>
                    </select>
                    <p>
                        <!--button 'Submit form'-->
                        <input type="submit" class="buttonSubmit" name="submitForm" value="Submit"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>