<html>
<head>
    <title>Web Application</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!--append css and jquery from google-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

    <!--append  JSTL-->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body>

<!--script for selector 'Time period'-->
<script>
    function timePeriod() {
        var select = document.getElementById("select").options.selectedIndex;

        if (select == 2) {

            var input1 = document.getElementById('startDateId');
            input1.value = "${LastQtrStartDate1}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${LastQtrEndDate1}"
        }
        else if (select == 3) {

            var input1 = document.getElementById('startDateId');
            input1.value = "${LastMonthStartDate1}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${LastMonthEndDate1}"
        }
        else if (select == 4) {

            var input1 = document.getElementById('startDateId');
            input1.value = "${LastYearStartDate1}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${LastYearEndDate1}"
        }
        else if (select == 5) {
            var input1 = document.getElementById('startDateId');
            input1.value = "${currentYearToDate1}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${endDateCurrentQuery1}"
        }
        else if (select == 6) {
            var input1 = document.getElementById('startDateId');
            input1.value = "${currentQerToDate1}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${endDateCurrentQuery1}"
        }
        else if (select == 7) {
            var input1 = document.getElementById('startDateId');
            input1.value = "${currentMonthToDate1}"
            var input2 = document.getElementById('endDateId');
            input2.value = "${endDateCurrentQuery1}"
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

            <!--version of events: Incorrectly filled date-->
            <c:if test="${!empty IncorFillDate}">
                <div class="dateError">Incorrectly filled date!</div>
                <div class="adviceForDate">
                    <p>Please, try format date:</p>

                    <p>MMM D, YYYY</p>

                    <p>Use english names of months</p></div>
            </c:if>

            <!--version of events: Not found performers-->
            <c:if test="${empty IncorFillDate}">
            <c:if test="${empty Reports}">
                <div class="notFoundNote">Not found performers by your request, sorry.</div>
            </c:if>

            <!--output table with results by query-->
            <c:if test="${!empty Reports}">
            <div class="tableReport">
                <ul>
                    <table class="tableStyle">
                        <tr>
                            <th>id</th>
                            <th>start date</th>
                            <th>end date</th>
                            <th>performer</th>
                            <th>activity</th>
                        </tr>
                        <c:forEach items="${Reports}" var="report">
                            <tr>
                                <td><c:out value="${report.id} "/></td>
                                <td><c:out value="${report.startDate}"/></td>
                                <td><c:out value="${report.endDate}"/></td>
                                <td><c:out value="${report.performer}"/></td>
                                <td><c:out value="${report.activity}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </ul>
                </c:if>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>

</html>