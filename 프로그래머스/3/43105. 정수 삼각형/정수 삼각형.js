function solution(triangle) {
    
    for(let row = triangle.length-2; row>=0; row--){
        for(let col = 0; col<triangle[row].length; col++){
            let left = triangle[row+1][col];
            let right = triangle[row+1][col+1];
            
            triangle[row][col]+= left>right ? left :right;
        }
    }
    
    return triangle[0][0];
}