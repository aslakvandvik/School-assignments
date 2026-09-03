
Highcharts.chart('container', {
    chart: {
        type: 'spline'
    },
    title: {
        text: 'Antall brukte og nye produkter kjøpt per måned'
    },
    xAxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Okt', 'Nov', 'Des']
    },
    yAxis: {
        title: {
            text: 'Antall'
        }
    },
    series: [{
        name: 'Brukte varer kjøpt',
        data: [10, 9, 8, 5, 2, 1, 7, 3, 5, 7, 6, 5, 3],
        color: '#00FF00'
    }, {
        name: 'Nye varer kjøpt',
        data: [5, 10, 7, 5, 9, 2, 5, 4, 3, 8, 9, 2, 6],
        color: '#FF0000'
    }]
});