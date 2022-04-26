let data = [1, 3, 7, -1, -1, 11, -1, -1, 5, 17, -1, -1, -1];

class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

function buildTree(root) {
  const num = data.shift();
  root = new Node(num);

  if (num === -1) {
    return null;
  }

  console.log(`Enter data for inserting in left of ${num}`);
  root.left = buildTree(root.left);
  console.log(`Enter data for inserting in right of ${num}`);
  root.right = buildTree(root.right);
  return root;
}

function levelOrderTraversal(root) {
  let q = [];
  q.push(root);
  q.push(null);

  while (q.length > 0) {
    let node = q.shift();
    if (node === null) {
      process.stdout.write("\n");
      if (q.length > 0) {
        q.push(null);
      }
    } else {
      process.stdout.write(`${node.data} `);

      if (node.left !== null) {
        q.push(node.left);
      }
      if (node.right !== null) {
        q.push(node.right);
      }
    }
  }
}

function reverseLevelOrderTraversal(root) {
  let q = [];
  let s = [];
  q.push(root);
  q.push(null);

  while (q.length > 0) {
    let node = q[0];
    q.shift();
    s.push(node);

    if (node === null) {
      if (q.length > 0) {
        q.push(null);
      }
    } else {
      if (node.right !== null) {
        q.push(node.right);
      }
      if (node.left !== null) {
        q.push(node.left);
      }
    }
  }

  while (s.length > 0) {
    let node = s.pop();
    if (node === null) {
      process.stdout.write("\n");
    } else {
      process.stdout.write(`${node.data} `);
    }
  }
}

function inOrder(node) {
  if (!node) return;

  inOrder(node.left);
  process.stdout.write(`${node.data} `);
  inOrder(node.right);
}

function preOrder(node) {
  if (!node) return;

  process.stdout.write(`${node.data} `);
  preOrder(node.left);
  preOrder(node.right);
}

function postOrder(node) {
  if (!node) return;

  postOrder(node.left);
  postOrder(node.right);
  process.stdout.write(`${node.data} `);
}

let root = null;

// 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
root = buildTree(root);

// levelOrderTraversal(root);
// reverseLevelOrderTraversal(root);
// inOrder(root);
// preOrder(root);
postOrder(root);
