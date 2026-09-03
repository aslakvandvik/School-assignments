        // Highcharts code for chart generation
        Highcharts.chart('chart-container', {
            chart: {
                type: 'spline'
            },
            title: {
                text: 'Utgifter vs Mål'
            },
            xAxis: {
                type: 'datetime',
                title: {
                    text: 'Dato'
                }
            },
            yAxis: {
                title: {
                    text: 'Utgifter'
                }
            },
            series: [{
                name: 'Utgifter',
                data: [
                    [Date.UTC(2023, 1, 1), 10000],
                    [Date.UTC(2023, 2, 1), 15000],
                    [Date.UTC(2023, 3, 1), 12000],
                    [Date.UTC(2023, 4, 1), 17000],
                    [Date.UTC(2023, 5, 1), 22000],
                    [Date.UTC(2023, 6, 1), 19000],
                    [Date.UTC(2023, 7, 1), 24000],
                    [Date.UTC(2023, 8, 1), 21000],
                    [Date.UTC(2023, 9, 1), 26000],
                    [Date.UTC(2023, 10, 1), 24000],
                    [Date.UTC(2023, 11, 1), 21000],
                    [Date.UTC(2023, 12, 1), 26000]
                
                ]
            }, {
                name: 'Mål',
                data: [
                    [Date.UTC(2023, 1, 1), 20000],
                    [Date.UTC(2023, 12, 1), 20000]
                ],
                color: 'red',
                dashStyle: 'dash'
            }]
        });
    
           
        
          








