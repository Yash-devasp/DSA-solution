class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

// recursive function for inorder
// time complexity: O(n)
// considering stack space - space complexity: O(h)
// worst case space: O(n) skewed tree
// best case space: O(log n) balanced tree
function inorder(node) {
  if (node === null) {
    return;
  }

  inorder(node.left);
  process.stdout.write(`${node.data} `);
  inorder(node.right);
}

// iterative function using stack
// time complexity: O(n)
// space complexity: O(n)
function inorderUsingStack(node) {
  if (node === null) {
    return;
  }

  let curr = node;
  let s = [];

  while (curr !== null || s.length > 0) {
    while (curr !== null) {
      s.push(curr);
      curr = curr.left;
    }
    curr = s.pop();
    process.stdout.write(`${curr.data} `);

    curr = curr.right;
  }
}

// using morris traversal
// time complexity: O(n)
function morrisTraversal(node) {
  if (node === null) {
    return;
  }

  let current, pre;
  current = node;
  while (current !== null) {
    if (current.left === null) {
      process.stdout.write(`${current.data} `);
      current = current.right;
    } else {
      pre = current.left;
      while (pre.right !== null && pre.right !== current) {
        pre = pre.right;
      }

      if (pre.right === null) {
        pre.right = current;
        current = current.left;
      } else {
        pre.right = null;
        process.stdout.write(`${current.data} `);
        current = current.right;
      }
    }
  }
}

let root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);

process.stdout.write("The inorder traversal of the tree is: ");
// inorder(root);
// inorderUsingStack(root);
morrisTraversal(root);
