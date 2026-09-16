# 1. Define the 6 products and their prices in USD
usd_catalog = {
    "Laptop": 1200.00,
    "Smartphone": 800.00,
    "Headphones": 150.00,
    "Smartwatch": 250.00,
    "Backpack": 45.00,
    "Water Bottle": 25.00
}

# 2. Set the current USD to EUR exchange rate
# (e.g., 1 USD = 0.866 EUR)
usd_to_eur_rate = 0.866

# 3. Convert prices to Euros and round to 2 decimal places
eur_catalog = {product: round(price * usd_to_eur_rate, 2) for product, price in usd_catalog.items()}

# 4. Print the results clearly
print(f"{'Product':<15} | {'Price (USD)':<12} | {'Price (EUR)':<12}")
print("-" * 45)
for product in usd_catalog:
    usd_price = usd_catalog[product]
    eur_price = eur_catalog[product]
    print(f"{product:<15} | ${usd_price:<11,.2f} | €{eur_price:<11,.2f}")