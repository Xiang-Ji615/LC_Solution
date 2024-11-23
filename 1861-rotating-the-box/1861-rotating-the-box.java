class Solution {
    public char[][] rotateTheBox(char[][] box) {
        for(int i=0;i<box.length;i++){
            Integer le = null;
            for(int j=box[0].length - 1;j>=0;j--){
                if(le == null && box[i][j] == '.'){
                    le = j;
                }else if(box[i][j] == '#' && le != null){
                    box[i][j] = '.';
                    box[i][le--] = '#';
                }else if(box[i][j] == '*')
                    le = null;
            }
        }
        char[][] res = new char[box[0].length][box.length];
        for(int i=0;i<box.length;i++){
            for(int j=box[0].length - 1;j>=0;j--){
                res[j][box.length - i - 1] = box[i][j];
            }
        }
        return res;
    }
}