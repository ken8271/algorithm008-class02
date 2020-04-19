class TrapRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        int current = 0;

        while(current < height.length){
            while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                int v = height[stack.peek()];

                stack.pop();

                if(stack.isEmpty()){
                    break;
                }

                int dis = current - stack.peek() - 1;
                int minHeight = height[stack.peek()] > height[current] ? height[current] : height[stack.peek()];
                sum += (minHeight - v)*dis;
            }

            stack.push(current);
            current++;
        }

        return sum;
    }
}