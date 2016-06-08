@echo off
git checkout develop
git pull origin develop
echo "Please check out your feature branch again"
echo "After that, enter"
echo "git merge develop"
echo "Start committing on your feature branch"
echo "when done checkout develop and run push.cmd"
