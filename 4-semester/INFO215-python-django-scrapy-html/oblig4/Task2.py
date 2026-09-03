import pandas as pd

# Load the original file
df = pd.read_csv("Airlines.csv")  # Update this if the filename is different

# Rename the columns for Gephi
df.rename(columns={"AirportFrom": "Source", "AirportTo": "Target"}, inplace=True)

# Drop rows with missing values, if any
df = df.dropna(subset=["Source", "Target"])

# Save to a new CSV
df.to_csv("Airlines.csv", index=False)

print("✅ 'Airlines.csv' is ready for Gephi.")