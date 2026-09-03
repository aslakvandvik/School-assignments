

function search() {
    var searchInput = document.getElementById("searchInput").value;
    var resultsDiv = document.getElementById("results");
    resultsDiv.innerHTML = ""; // Clear previous results

    // Simulated data for demonstration purposes
    var products = [
        { name: "Databrus", price: 32 },
        { name: "Sokker", price: 150 },
        { name: "Samsung TV", price: 30000 },
        { name: "Tacobaguette", price: 50 },
        { name: "Iphone 15 pro max ultra 4k hdr uhd", price: 20000 },
        { name: "Brukt Databrus", price: 12 },
        { name: "Brukte Sokker", price: 15 },
        { name: "Brukt Samsung TV", price: 20000 },
        { name: "Brukt Tacobaguette", price: 17 },
        { name: "Brukt Iphone 15 pro max ultra 4k hdr uhd", price: 18000 }
    ];

    var matchingProducts = products.filter(function(product) {
        return product.name.toLowerCase().includes(searchInput.toLowerCase());
    });

    if (matchingProducts.length > 0) {
        matchingProducts.forEach(function(product) {
            var productDiv = document.createElement("div");
            productDiv.textContent = product.name + " - Pris: " + product.price + " kr";
            resultsDiv.appendChild(productDiv);
        });
    } else {
        resultsDiv.textContent = "Ingen resultater funnet.";
    }
}
