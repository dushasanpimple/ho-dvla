$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("vehicleCheck.feature");
formatter.feature({
  "line": 2,
  "name": "Check the vehicles  with DVLA and assert on the make and colour of the vehicle which reads from the",
  "description": "       CSV or XLS file configured in Config file",
  "id": "check-the-vehicles--with-dvla-and-assert-on-the-make-and-colour-of-the-vehicle-which-reads-from-the",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@dvla"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Verify make and colour of list of Vehicles",
  "description": "",
  "id": "check-the-vehicles--with-dvla-and-assert-on-the-make-and-colour-of-the-vehicle-which-reads-from-the;verify-make-and-colour-of-list-of-vehicles",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I navigate to the dvla page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I start the vehicle check",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I verify all the vehicles in \u0027verify.filetype\u0027 files from the list of files",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "print out the results to a file",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStep.navigateToPage()"
});
formatter.result({
  "duration": 7401309045,
  "status": "passed"
});
formatter.match({
  "location": "CommonStep.startVehicleCheck()"
});
formatter.result({
  "duration": 945240595,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "verify.filetype",
      "offset": 30
    }
  ],
  "location": "VehicleCheckSteps.verifyVechiles(String)"
});
formatter.result({
  "duration": 64717942087,
  "status": "passed"
});
formatter.match({
  "location": "VehicleCheckSteps.printResult()"
});
formatter.result({
  "duration": 6680549,
  "status": "passed"
});
});