 document.addEventListener("DOMContentLoaded", function () {
        if (ticker) {
            fetchStockData(ticker);
        }
    });

    function fetchStockData(ticker) {
        fetch(`/api/stockData?ticker=${ticker}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            })
            .then(stockData => {
                if (stockData && stockData.length > 0) {
                    const dates = stockData.map(data => data.date);
                    const openPrices = stockData.map(data => data.open_price);
                    const closePrices = stockData.map(data => data.close_price);
                    const highPrices = stockData.map(data => data.high_price);
                    const lowPrices = stockData.map(data => data.low_price);
                    plotStockData(ticker, dates, openPrices, closePrices, highPrices, lowPrices);
                } else {
                    alert("No stock data found.");
                }
            })
            .catch(error => {
                console.error("Error fetching stock data:", error);
            });
    }

    function plotStockData(ticker, dates, openPrices, closePrices, highPrices, lowPrices) {
        const trace1 = {
            x: dates,
            y: openPrices,
            mode: 'lines',
            name: 'Open Price',
            line: { color: 'blue' }
        };

        const trace2 = {
            x: dates,
            y: closePrices,
            mode: 'lines',
            name: 'Close Price',
            line: { color: 'green' }
        };

        const trace3 = {
            x: dates,
            y: highPrices,
            mode: 'lines',
            name: 'High Price',
            line: { color: 'orange' }
        };

        const trace4 = {
            x: dates,
            y: lowPrices,
            mode: 'lines',
            name: 'Low Price',
            line: { color: 'red' }
        };

        const layout = {
            title: `Historical Stock Data for ${ticker}`,
            xaxis: { title: 'Date' },
            yaxis: { title: 'Price' },
            margin: { t: 40 }
        };

        const data = [trace1, trace2, trace3, trace4];

        Plotly.newPlot('stockChart', data, layout);
    }