class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
    this.hd = 0;
  }
}

function topView(node) {
  if (node === null) {
    return;
  }

  let q = [];
  let m = new Map();
  let hd = 0;
  node.hd = hd;
  q.push(node);

  while (q.length !== 0) {
    node = q[0];
    hd = node.hd;

    if (!m.has(hd)) {
      m.set(hd, node.data);
    }

    if (node.left) {
      node.left.hd = hd - 1;
      q.push(node.left);
    }
    if (node.right) {
      node.right.hd = hd + 1;
      q.push(node.right);
    }
    q.shift();
  }

  let arr = Array.from(m);
  arr.sort(function (a, b) {
    return a[0] - b[0];
  });

  for (let [key, value] of arr.values()) {
    process.stdout.write(`${value} `);
  }
}

let root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.right = new Node(4);
root.left.right.right = new Node(5);
root.left.right.right.right = new Node(6);

process.stdout.write("Following are the nodes in top view of a binary tree: ");
topView(root);
