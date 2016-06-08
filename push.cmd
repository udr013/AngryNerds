@echo off

git checkout develop
git pull origin develop

echo "Enter $ git merge feature/<your feature branchname>"
echo "Than: enter $ git push origin develop"
echo "Than you might remove your feature branch with:"
echo "$ git branch -d feature/<yourbranchname>


echo "When error messages appear than you have to investigate that you did all commit in your feature branch"
echo "if not you have to checkout your feature branch again and do the commits again in that feature branch"
echo "Than retry the steps above"
