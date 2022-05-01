class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

let max_level = 0;

// recursive function
// time complexity: O(n)
// space complexity: O(n) considering stack space
function rightViewUtil(node, level) {
  if (node === null) {
    return;
  }

  if (level > max_level) {
    process.stdout.write(`${node.data} `);
    max_level = level;
  }

  rightViewUtil(node.right, level + 1);
  rightViewUtil(node.left, level + 1);
}

function rightView(node) {
  rightViewUtil(node, 1);
}

// using queue
function rightViewIterative(node) {
  if (node === null) {
    return;
  }

  let q = [];
  q.push(node);

  while (q.length > 0) {
    let n = q.length;

    while (n-- > 0) {
      let x = q[0];
      q.shift();

      if (n === 0) {
        process.stdout.write(`${x.data} `);
      }
      if (x.left !== null) {
        q.push(x.left);
      }
      if (x.right !== null) {
        q.push(x.right);
      }
    }
  }
}

let root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);
root.right.left = new Node(6);
root.right.right = new Node(7);
root.right.right.right = new Node(8);

// rightView(root);
rightViewIterative(root);
