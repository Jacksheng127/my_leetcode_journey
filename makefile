commit:
	@git add .
	@git commit -m "$(message)"
	@git push origin main

create:
	@mkdir -p $(folder)
	@cd $(folder) && touch $(file)