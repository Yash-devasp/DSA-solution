class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

// recursive function
// time complexity: O(n)
// space complexity: O(n) considering the stack space
function postOrder(node) {
  if (node === null) {
    return;
  }

  postOrder(node.left);
  postOrder(node.right);
  process.stdout.write(`${node.data} `);
}

// iterative approach using 2 stacks
// time complexity: O(n)
function postOrderUsing2Stacks(node) {
  if (node === null) {
    return;
  }

  let s1 = [];
  let s2 = [];

  s1.push(node);

  while (s1.length > 0) {
    let tempNode = s1.pop();
    s2.push(tempNode);

    if (tempNode.left !== null) {
      s1.push(tempNode.left);
    }
    if (tempNode.right !== null) {
      s1.push(tempNode.right);
    }
  }

  while (s2.length > 0) {
    let temp = s2.pop();
    process.stdout.write(`${temp.data} `);
  }
}

// iterative function using one stack
function postorderUsingOneStack(node) {
  let stack = [];
  while (true) {
    while (node !== null) {
      stack.push(node);
      stack.push(node);
      node = node.left;
    }

    if (stack.length === 0) return;
    node = stack.pop();
    if (stack.length !== 0 && stack[stack.length - 1] === node) {
      node = node.right;
    } else {
      process.stdout.write(`${node.data} `);
      node = null;
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

process.stdout.write("The post order of the tree is: ");
// postOrder(root);
// postOrderUsing2Stacks(root);
postorderUsingOneStack(root);
