class Node {
  constructor() {
    this.data = 0;
    this.left = null;
    this.right = null;
  }
}

function createNode(val) {
  let newNode = new Node();
  newNode.data = val;
  return newNode;
}

function inorder(node) {
  if (node === null) {
    return;
  }

  inorder(node.left);
  process.stdout.write(`${node.data} `);
  inorder(node.right);
}

// Function to create a duplicate tree that is a mirror
function mirrorify(root) {
  if (root === null) {
    return null;
  }
  let mirrorNode = createNode(root.data);
  mirrorNode.right = mirrorify(root.left);
  mirrorNode.left = mirrorify(root.right);
  return mirrorNode;
}

// function to modify the actual tree to create a mirror
function mirrorifyTree(root) {
  if (root === null) {
    return null;
  }

  let left = mirrorifyTree(root.left);
  let right = mirrorifyTree(root.right);

  root.left = right;
  root.right = left;

  return root;
}

let tree = createNode(5);
tree.left = createNode(3);
tree.right = createNode(6);
tree.left.left = createNode(2);
tree.left.right = createNode(4);

process.stdout.write("The inorder of the main tree: ");
inorder(tree);

process.stdout.write("\nThe inorder of the mirror tree: ");
// mirrorifyTree(tree);
// inorder(tree);
let mirrorTree = mirrorify(tree);
inorder(mirrorTree);
