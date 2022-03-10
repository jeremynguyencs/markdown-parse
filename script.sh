for file in test-files/*.md;
do
  echo $file
  java MarkdownParse $file
  echo
done