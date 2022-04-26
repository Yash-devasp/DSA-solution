class Node {
  constructor(val) {
    this.data = val;
    this.left = null;
    this.right = null;
  }
}

class BinaryTree {
  constructor() {
    this.root = null;
  }

  height(node) {
    if (node === null) return 0;
    else {
      let lheight = this.height(node.left);
      let rheight = this.height(node.right);

      if (lheight > rheight) {
        return lheight + 1;
      } else {
        return rheight + 1;
      }
    }
  }

  printGivenLevel(node, level) {
    if (node === null) return;

    if (level === 1) process.stdout.write(`${node.data} `);
    else if (level > 1) {
      this.printGivenLevel(node.left, level - 1);
      this.printGivenLevel(node.right, level - 1);
    }
  }

  //   Using function to print a particular level
  // time complexity: O(n^2)
  reverseLevelOrder(node) {
    let h = this.height(node);
    for (let i = h; i >= 1; i--) {
      this.printGivenLevel(node, i);
    }
  }

  //   Using Queue and Stack
  // time complexity: O(n)
  // space complexity: O(n)
  printReverseLevelOrder(node) {
    let s = [];
    let q = [];

    q.push(node);
    while (q.length !== 0) {
      node = q[0];
      q.shift();
      s.push(node);

      if (node.right !== null) {
        q.push(node.right);
      }
      if (node.left !== null) {
        q.push(node.left);
      }
    }

    while (s.length !== 0) {
      node = s.pop();
      process.stdout.write(`${node.data} `);
    }
  }
}

const tree = new BinaryTree();

tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(5);

// tree.reverseLevelOrder(tree.root);
tree.printReverseLevelOrder(tree.root);
