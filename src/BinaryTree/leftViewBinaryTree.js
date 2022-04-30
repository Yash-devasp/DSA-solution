class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

let root;
let max_level = 0;

// recursive method
// time complexity: O(n)
// space complexity: O(n) considering stack space
function leftViewUtil(node, level) {
  if (node === null) {
    return;
  }
  if (max_level < level) {
    process.stdout.write(`${node.data} `);
    max_level = level;
  }

  leftViewUtil(node.left, level + 1);
  leftViewUtil(node.right, level + 1);
}

function leftView() {
  leftViewUtil(root, 1);
}

// iterative method using queue
// time complexity: O(n)
function iterativeLeftView(node) {
  if (node === null) {
    return;
  }

  let q = [];
  q.push(node);

  while (q.length > 0) {
    let n = q.length;
    for (let i = 1; i <= n; i++) {
      let temp = q.shift();
      if (i == 1) {
        process.stdout.write(`${temp.data} `);
      }
      if (temp.left !== null) {
        q.push(temp.left);
      }
      if (temp.right !== null) {
        q.push(temp.right);
      }
    }
  }
}

root = new Node(10);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(7);
root.left.right = new Node(8);
root.right.right = new Node(15);
root.right.left = new Node(12);
root.right.right.left = new Node(14);

// leftView();
iterativeLeftView(root);
