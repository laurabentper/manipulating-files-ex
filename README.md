The program reads the path of a `.csv` file that contains data about sold items (name, unit price, and quantity), with values separated by commas. It then generates a new file named "summary.txt" in a subfolder called "out", located in the same directory as the original file. The new file will include only the name of each item and the total value for that item (calculated by multiplying the unit price by the quantity).
### Exemple:
#### Source file: 
TV LED,1290.99,1 <br>
Video Game Chair,350.50,3 <br>
Iphone X,900.00,2 <br>
Samsung Galaxy 9,850.00,2 <br>
#### Output file (out/summary.txt): 
TV LED - 1290,99 <br>
Video Game Chair - 1051,50 <br>
Iphone X - 1800,00 <br>
Samsung Galaxy 9 - 1700,00 <br>
