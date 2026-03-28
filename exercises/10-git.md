# Section 10 — Version Control (Git)

Do these in your terminal. Every command is real — run it and observe the output.

---

## Exercise 10.1 — Git Workflow Drill

**Difficulty:** Core | **Topic:** Git Commands, Branching, Merging

Open your terminal and do the following steps in order. **Write down what each command does as you go:**

1. `mkdir java-practice && cd java-practice && git init`
2. Create a file `Hello.java` with a simple class. `git add Hello.java`. `git commit -m "Add Hello class"`
3. `git status` — what do you see?
4. `git log` — what do you see?
5. `git branch feature/bank-account`
6. `git checkout feature/bank-account`
7. Create `BankAccount.java` (use your Exercise 2.1 solution). `git add . && git commit -m "Add BankAccount class"`
8. `git checkout main` (or master)
9. `git merge feature/bank-account`
10. `git log --oneline` — what do you see now?
11. `git diff HEAD~1 HEAD` — what does this show?
12. Deliberately edit `Hello.java` but do NOT commit. Run `git status` and `git diff`. Observe the difference.
13. `git stash` — what happens to your changes?
14. `git stash pop` — what comes back?

**Git commands to know cold:**
```
git init / git clone          → start a repo
git add / git commit -m       → stage and save
git status / git log / git diff → inspect state
git branch / git checkout     → branching
git merge / git rebase        → combining work
git push / git pull           → remote sync
git stash / git stash pop     → temporary save
```
