class Node {
  constructor(val) {
    this.data = val;
    this.right = null;
    this.left = null;
  }
}

let root = null;

function height(node) {
  if (node === null) {
    return 0;
  } else {
    let lHeight = height(node.left);
    let rheight = height(node.right);

    if (lHeight > rheight) {
      return lHeight + 1;
    } else {
      return rheight + 1;
    }
  }
}

function heightUsingQueue() {
  let q = [];
  q.push(root);
  q.push(null);

  let count = 0;
  while (q.length !== 0) {
    let temp = q.shift();

    if (temp === null) {
      count++;
      if (q.length !== 0) {
        q.push(null);
      }
    } else {
      if (temp.left !== null) {
        q.push(temp.left);
      }
      if (temp.right !== null) {
        q.push(temp.right);
      }
    }
  }
  return count;
}

root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);

console.log(`Height of tree: ${heightUsingQueue()}`);
