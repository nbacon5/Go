public enum PointStatus{ 
    BLACK, WHITE, EMPTY; 

    private char symbol; 
    private PointStatus opposite; 

    static{ 
     BLACK.symbol = 'B'; 
     WHITE.symbol = 'W'; 
     EMPTY.symbol = '+'; 
     BLACK.opposite = WHITE; 
     WHITE.opposite = BLACK; 
    } 

    public char symbol(){ 
     return symbol; 
    } 

    public PointStatus opposite(){ 
     return opposite; 
    } 
}
