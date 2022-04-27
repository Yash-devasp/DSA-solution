class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

class Height {
  constructor() {
    this.h = 0;
  }
}

function height(node) {
  if (node === null) {
    return 0;
  }

  return 1 + Math.max(height(node.left), height(node.right));
}

// Time complexity: O(n^2)
function diameter(root) {
  if (root === null) {
    return 0;
  }

  let lheight = height(root.left);
  let rheight = height(root.right);

  let ldiameter = diameter(root.left);
  let rdiameter = diameter(root.right);

  return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
}

function diameterOpt(root, height) {
  let lh = new Height();
  let rh = new Height();

  if (root === null) {
    height.h = 0;
    return 0;
  }

  let ldiameter = diameterOpt(root.left, lh);
  let rdiameter = diameterOpt(root.right, rh);

  height.h = Math.max(lh.h, rh.h) + 1;

  return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
}

// optimized version of above code
// time complexity: O(n)
function diameterOptimized(root) {
  let height = new Height();
  return diameterOpt(root, height);
}

let root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);

console.log(`The diameter of the tree is ${diameterOptimized(root)}`);
