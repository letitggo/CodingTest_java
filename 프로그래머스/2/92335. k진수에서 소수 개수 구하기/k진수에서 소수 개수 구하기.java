
class Solution {
    int solution(int n, int k) {

        if(n < 1 || n > 1000000 || k < 3 || k > 10){
            return -1;
        }

        int answer = 0;
        int[] arr = new int[64];

        int length = 0;

        // k 진수 변환
        while(true){
            if(n < k){
                arr[length] = n;
                break;
            }
            arr[length] = n%k;
            n = n/k;
            length++;
        }

        int i = length;

        while(true){
            if(i < 0) break;
            StringBuilder sb = new StringBuilder();
            while(arr[i] != 0){
                sb.append(arr[i]);
                i--;
                if(i < 0) break;
            }

            /** sb가 소수인지 검증 **/
            if(!sb.toString().equals("") || !sb.toString().isEmpty() || !sb.toString().isBlank()){
                long temp = Long.parseLong(sb.toString());
                if (isPrime(temp)) {
                    answer++;
                }
            }
            i--;
        }
        return answer;
    }

    boolean isPrime(long n) {
        if(n > 2){
            for (int j = 2; j <= Math.sqrt(n) + 1; j++) {
                if(n % j == 0){
                    // 소수 아님
                    return false;
                }
            }
            // 소수임
            return true;
        }else if(n == 2){
            // n = 2 면 소수
            return true;
        }else {
            // 그 외엔 소수 아님
            return false;
        }
    }
}