class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

let root = null;

function height(node) {
  if (node === null) return 0;
  else {
    let lheight = height(node.left);
    let rheight = height(node.right);

    if (lheight > rheight) return lheight + 1;
    else return rheight + 1;
  }
}

function printCurrentLevel(node, level) {
  if (node === null) return;
  if (level === 1) {
    process.stdout.write(`${node.data} `);
  } else if (level > 1) {
    printCurrentLevel(node.left, level - 1);
    printCurrentLevel(node.right, level - 1);
  }
}

// Using function to print current level
// Time Complexity: O(n^2)
// space Complexity: O(n)
function printLevelOrder() {
  let h = height(root);
  for (let i = 1; i <= h; i++) {
    printCurrentLevel(root, i);
  }
}

// using queue
// Time Complexity: O(n)
// space Complexity: O(n)
function levelOrder() {
  let queue = [];
  queue.push(root);
  while (queue.length != 0) {
    let tempNode = queue.shift();
    process.stdout.write(`${tempNode.data} `);

    if (tempNode.left !== null) {
      queue.push(tempNode.left);
    }
    if (tempNode.right !== null) {
      queue.push(tempNode.right);
    }
  }
}

root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);

process.stdout.write("Level order traversal of binary tree is \n");
// printLevelOrder();
levelOrder();
