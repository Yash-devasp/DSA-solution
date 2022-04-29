class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

// recursive method
// time complexity: O(n)
// space complexity: O(n) considering stack space
function preorder(node) {
  if (node === null) {
    return;
  }

  process.stdout.write(`${node.data} `);
  preorder(node.left);
  preorder(node.right);
}

// iterative method
// time complexity: O(n)
// space complexity: O(n)
function iterativePreorder(node) {
  if (node === null) {
    return;
  }

  let nodeStack = [];
  nodeStack.push(node);

  while (nodeStack.length > 0) {
    let getNode = nodeStack.pop();
    process.stdout.write(`${getNode.data} `);

    if (getNode.right !== null) {
      nodeStack.push(getNode.right);
    }

    if (getNode.left !== null) {
      nodeStack.push(getNode.left);
    }
  }
}

// optimized iterative process
function preorderIterative(node) {
  if (node === null) {
    return;
  }

  let s = [];

  let curr = node;

  while (curr !== null || s.length > 0) {
    while (curr !== null) {
      process.stdout.write(`${curr.data} `);
      if (curr.right !== null) {
        s.push(curr.right);
      }
      curr = curr.left;
    }
    if (s.length > 0) {
      curr = s.pop();
    }
  }
}

let root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);

process.stdout.write("The PreOrder of the tree is: ");
// preorder(root);
// iterativePreorder(root);
preorderIterative(root);
