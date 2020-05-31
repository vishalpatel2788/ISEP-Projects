$(document).ready(function () {
  // Get JSON data from url
  $.getJSON("https://api.covid19api.com/summary", function (data) {
    var countries = [];
    var confirmed = [];
    var recovered = [];
    var deaths = [];


    var total_confirmed;
    var total_recovered;
    var total_deaths;

    // Take the first element in statewise array and add the objects values into the above variables

    total_confirmed = data.Countries[0].TotalConfirmed;
    total_recovered = data.Countries[0].TotalRecovered;
    total_deaths = data.Countries[0].TotalDeaths;

    // The each loop select a single Countries array element
    // Take the data in that array and add it to variables
    $.each(data.Countries, function (id, obj) {
      countries.push(obj.Country);
      confirmed.push(obj.TotalConfirmed);
      recovered.push(obj.TotalRecovered);
      deaths.push(obj.TotalDeaths);
    });

    // Remove the first element in the states, confirmed, recovered, and deaths as that is the total value

    // console.log(confirmed);
    $("#TotalConfirmed").append(total_confirmed);
    $("#TotalRecovered").append(total_recovered);
    $("#TotalDeaths").append(total_deaths);
 

// Chart initialization
    var myChart = document.getElementById("myWorldChart").getContext("2d");
    var chart = new Chart(myChart, {
      type: "line",
      data: {
        labels: countries,
        datasets: [
          {
            label: "Confirmed Cases",
            data: confirmed,
            backgroundColor: "#f1c40f",
            minBarLength: 1000,
          },
          {
            label: "Recovered",
            data: recovered,
            backgroundColor: "#2ecc71",
            minBarLength: 1000,
          },
          {
            label: "Deceased",
            data: deaths,
            backgroundColor: "#e74c3c",
            minBarLength: 1000,
          },
        ],
      },
      option: {},
    });
  });
});
