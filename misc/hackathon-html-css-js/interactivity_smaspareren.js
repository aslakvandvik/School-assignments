Highcharts.chart('container', {
    chart: {
      type: 'column'
    },
    title: {
      text: 'Utgifter'
    },
    xAxis: {
      categories: ['Nødvendige utgifter', 'Unødvendige utgifter', 'Sparepotensial']
    },
    yAxis: {
      title: {
        text: 'Beløp'
      }
    },
    series: [{
      name: 'Utgifter og Sparepotensial',
      data: [9000, 8000, 2000],
      colors: ['green', 'red', 'blue']
    }],
    
    
        plotOptions: {
            column: {
                colorByPoint : true
            }
        },
        colors: ['green', 'red', 'blue']
    
  });
